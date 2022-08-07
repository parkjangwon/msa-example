package in.parkjw.apps.board.controller;

import in.parkjw.apps.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board/v1")
public class BoardAPI {

    final BoardService boardService;

    @GetMapping("test")
    public String test() {

        return boardService.test();
    }
}
