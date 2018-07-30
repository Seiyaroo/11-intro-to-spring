package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controllers {
    @RequestMapping("/")
    public String getHomePage () {
        return "index";
    }

    @GetMapping("/search")
    public String albumSearch (@RequestParam(name = "query", defaultValue = "Metallica") String query, Model model) {
        String src = Scraper.AlbumScraper(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);

        return "albums";
    }

    @RequestMapping("*")
    @ResponseBody
    public String notFound() {
        return "404";
    }
}
