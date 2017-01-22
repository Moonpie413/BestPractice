package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spittr.data.SpittrRepository;
import spittr.pojo.User;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value = "max", defaultValue = "100000") long max,
            @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        model.addAttribute("spittleList", repository.findSpittles(max, count));
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String stitter(@PathVariable Long spittleId, Model model) {
        model.addAttribute("spittle", repository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute(new User());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Map<String, String> processRegister(
            @RequestPart MultipartFile file, @Valid User user, BindingResult bindingResult, Model model) {
        Map<String, String> datas = new HashMap<>();
        if (bindingResult.hasErrors()) {
            datas.put("error", bindingResult.getAllErrors().toString());
        }
        datas.put("username", user.getUsername());
        datas.put("filename", file.getOriginalFilename());
        return datas;
    }
}
