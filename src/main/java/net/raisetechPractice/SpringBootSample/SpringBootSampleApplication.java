package net.raisetechPractice.SpringBootSample;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringBootSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }

    // 名前と生年月日を受け取る
    @GetMapping("/userdata")
    public String hello(@Length(max = 2) @RequestParam(value = "name", defaultValue = "Tanaka") String name, @RequestParam(value = "DOB", defaultValue = "2000-01-01") String dob){
        // nameの文字数が20字以内かチェック
        @Length(max=20)
        String username = name;

        return String.format("name: %s, DOB:%s", username, dob);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postMethod(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("data successfully created");
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "data successfully updated"));
    }

    @DeleteMapping("/delete")
    public String deleteMethod(@RequestParam(value = "item", defaultValue = "POST") String item) {
        return String.format("%s data successfully deleted", item);
    }
}
