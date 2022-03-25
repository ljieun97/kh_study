package com.example.bank.service.jpa;

import com.example.bank.entity.jpa.JpaBoard;
import com.example.bank.repository.jpa.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
    @Autowired
    JpaBoardRepository repository;

    @Override
    public void register(JpaBoard board) {
        repository.save(board);
    }

    @Override
    public List<JpaBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public JpaBoard read(Integer boardNo) {
        Optional<JpaBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {

            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(JpaBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
