package io.github.ewnolin.urd.app.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class LocaleSelectionTest {

  private static final String SWEDISH_TAGLINE = "Bokföring för ett litet aktiebolag";
  private static final String ENGLISH_TAGLINE = "Bookkeeping for a small limited company";

  @Autowired private MockMvc mockMvc;

  @Test
  void swedishIsTheDefault() throws Exception {
    mockMvc
        .perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("lang=\"sv\"")))
        .andExpect(content().string(containsString(SWEDISH_TAGLINE)));
  }

  @Test
  void englishCanBeSelectedAndIsRememberedInACookie() throws Exception {
    mockMvc
        .perform(get("/").param("lang", "en"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(ENGLISH_TAGLINE)))
        .andExpect(cookie().value(LocaleConfig.COOKIE_NAME, "en"));
  }

  @Test
  void cookieSelectsLanguageOnLaterRequests() throws Exception {
    mockMvc
        .perform(get("/").cookie(new Cookie(LocaleConfig.COOKIE_NAME, "en")))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(ENGLISH_TAGLINE)));
  }

  @Test
  void unsupportedLanguageFallsBackToSwedish() throws Exception {
    mockMvc
        .perform(get("/").param("lang", "fr"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(SWEDISH_TAGLINE)));
  }
}
