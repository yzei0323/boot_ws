package com.acorn.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    public List<BoardDTO> getSearchBoard( SearchCondition search){
        return repository.selectBoardSearch(search);
    }
}
