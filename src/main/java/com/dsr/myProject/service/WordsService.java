package com.dsr.myProject.service;

import com.dsr.myProject.model.Word;
import com.dsr.myProject.repository.WordsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordsService {
    @Autowired
    private WordsRepository wordsRepository;

    @Transactional
    public List<Word> getAll() {
        return Lists.newArrayList(wordsRepository.findAll());
    }
    @Transactional
    public Word getOne(Long id){
        return wordsRepository.findOne(id);
    }

    @Transactional
    public Word create(Word word){
        Word newWord = new Word();
        newWord.setOriginal(word.getOriginal());
        newWord.setTranslated(word.getTranslated()  );
        newWord.setPriority(Math.abs(newWord.getOriginal().hashCode()) % 5);
        return wordsRepository.save(newWord);
    }

    @Transactional
    public void delete(Long id){
        wordsRepository.delete(id);
    }

    @Transactional
    public Word update(Long id, Word word){
        Word newWord = wordsRepository.findOne(id);
        newWord.setOriginal(word.getOriginal());
        newWord.setTranslated(word.getTranslated());
        newWord.setPriority(Math.abs(newWord.getOriginal().hashCode()) % 5);
        return wordsRepository.save(newWord);
    }

    @Transactional
    public List<Word> findWordsForTest(){
        List<Word> result = new ArrayList<Word>();
        result.addAll(wordsRepository.findLimited(4, new PageRequest(0, 5)));
        result.addAll(wordsRepository.findLimited(3, new PageRequest(0, 4)));
        result.addAll(wordsRepository.findLimited(2, new PageRequest(0, 3)));
        result.addAll(wordsRepository.findLimited(1, new PageRequest(0, 2)));
        result.addAll(wordsRepository.findLimited(0, new PageRequest(0, 1)));
        return result;
    }

    @Transactional
    public List<Word> findWordsByPriority(Integer priority){
        return wordsRepository.findLimited(priority, new PageRequest(0, 15));
    }
}
