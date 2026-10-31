package io.github.ewnolin.urd.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Serves the start page. */
@Controller
class HomeController {

  @GetMapping("/")
  String home() {
    return "index";
  }
}
