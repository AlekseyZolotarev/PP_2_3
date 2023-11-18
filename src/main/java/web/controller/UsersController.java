package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/show";
    }

    @GetMapping("/id")
    public String show1(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/show1";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/change")
    public String changeUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "/change";
    }

    @PatchMapping("/{id}")
    public String change(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/change1/id")
    public String changeUser1(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "/change1";
    }

    @PatchMapping("change1/id")
    public String change1(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, @ModelAttribute("user") User user) {
        userService.editUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @DeleteMapping("delete/id")
    public String deletUser(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
