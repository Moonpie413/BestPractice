package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spittr.data.SpittrRepository;
import spittr.pojo.User;

import javax.validation.Valid;

/**
 * Created by wangxh on 17-1-5.
 * Package spittr.web
 * DES:
 */
@Controller
@RequestMapping("/spittles/")
public class SpittleController {
    private final SpittrRepository repository;

    @Autowired
    public SpittleController(SpittrRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String spittles(
            @RequestParam(value = "max", defaultValue = "100000") long max,
            @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        model.addAttribute("spittleList", repository.findSpittles(max, count));
        return "spittles";
    }

    @GetMapping("/{spittleId}")
    public String stitter(@PathVariable Long spittleId, Model model) {
        model.addAttribute("spittle", repository.findOne(spittleId));
        return "spittle";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute(new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String processRegister(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        model.addAttribute("user", user);
        return "showuser";
    }
}
