package io.github.ewnolin.urd.app.web;

import java.util.Locale;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Language handling for the user interface.
 *
 * <p>Swedish is the default. The user switches language with the {@code lang} request parameter
 * ({@code ?lang=en}), and the choice is remembered in a cookie. Only the supported languages are
 * accepted; anything else falls back to the default.
 *
 * <p>Reports will default to English (ADR 0010) and use the same message bundles with an explicit
 * locale, independent of the UI choice.
 */
@Configuration
class LocaleConfig implements WebMvcConfigurer {

  static final Locale DEFAULT_LOCALE = Locale.forLanguageTag("sv");
  static final Set<Locale> SUPPORTED_LOCALES = Set.of(DEFAULT_LOCALE, Locale.ENGLISH);
  static final String COOKIE_NAME = "urd-lang";
  static final String PARAM_NAME = "lang";

  @Bean
  LocaleResolver localeResolver() {
    CookieLocaleResolver resolver = new CookieLocaleResolver(COOKIE_NAME);
    resolver.setDefaultLocale(DEFAULT_LOCALE);
    return resolver;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SupportedLocaleChangeInterceptor());
  }

  /** Accepts only supported languages; an unsupported value resets to the default. */
  private static final class SupportedLocaleChangeInterceptor extends LocaleChangeInterceptor {

    SupportedLocaleChangeInterceptor() {
      setParamName(PARAM_NAME);
      setIgnoreInvalidLocale(true);
    }

    @Override
    protected Locale parseLocaleValue(String localeValue) {
      Locale requested = Locale.forLanguageTag(localeValue);
      return SUPPORTED_LOCALES.contains(requested) ? requested : DEFAULT_LOCALE;
    }
  }
}
