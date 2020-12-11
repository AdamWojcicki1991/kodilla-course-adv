package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookMapper {

    public static Book toBook(BookDto bookDto) {
        return Book.of(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear());
    }

    public static BookDto toBookDto(Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getYear());
    }

    public static List<Book> toBookList(List<BookDto> bookDtos) {
        return bookDtos.stream().map(BookMapper::toBook).collect(toList());
    }

    public static List<BookDto> toBookDtoList(List<Book> books) {
        return books.stream().map(BookMapper::toBookDto).collect(toList());
    }
}
