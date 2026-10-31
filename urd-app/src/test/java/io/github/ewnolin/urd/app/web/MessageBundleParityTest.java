package io.github.ewnolin.urd.app.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.junit.jupiter.api.Test;

/** Every UI text must exist in both Swedish and English. */
class MessageBundleParityTest {

  @Test
  void swedishAndEnglishBundlesHaveTheSameKeys() throws IOException {
    Properties swedish = load("messages_sv.properties");
    Properties english = load("messages_en.properties");

    assertThat(swedish.stringPropertyNames())
        .as("keys in messages_sv compared with messages_en")
        .containsExactlyInAnyOrderElementsOf(english.stringPropertyNames());
  }

  @Test
  void noBundleContainsBlankTexts() throws IOException {
    for (String bundle : new String[] {"messages_sv.properties", "messages_en.properties"}) {
      Properties texts = load(bundle);
      assertThat(texts.stringPropertyNames())
          .as("keys with blank values in %s", bundle)
          .noneMatch(key -> texts.getProperty(key).isBlank());
    }
  }

  private static Properties load(String name) throws IOException {
    try (InputStream in = MessageBundleParityTest.class.getClassLoader().getResourceAsStream(name)) {
      assertThat(in).as("bundle %s on the classpath", name).isNotNull();
      Properties properties = new Properties();
      properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
      return properties;
    }
  }
}
