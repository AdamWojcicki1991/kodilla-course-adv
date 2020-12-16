package com.kodilla.exercise.processor;

import com.kodilla.exercise.domain.ProcessedUser;
import com.kodilla.exercise.domain.User;
import org.springframework.batch.item.ItemProcessor;

import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.Period.between;

public class UserProcessor implements ItemProcessor<User, ProcessedUser> {
    @Override
    public ProcessedUser process(User item) throws Exception {
        return new ProcessedUser(item.getName(), item.getSurname(), between(parse(item.getBirthDate()), now()).getYears());
    }
}
