package example.co.jp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

//    @PostMapping("/users")
//    public ResponseEntity<String> postMethod(@Validated @RequestBody UserForm form, BindingResult result, UriComponentsBuilder uriBuilder) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body("error");
//        }
//
//        User createdUser = new User(users.size() + 1, form.getName());
//        users.add(createdUser);
//
//        String createdName = form.getName();
//
//        URI location = uriBuilder.path("/post").buildAndExpand(createdName).toUri();
//
//        return ResponseEntity.created(location).body("正常に作成されました：" + createdName);
//    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UserForm form) {
        User user = new User(id, form.getName());
        userService.update(user);

        return ResponseEntity.ok(Map.of("message", "正常に更新されました："));
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "正常に削除されました";
    }
}
