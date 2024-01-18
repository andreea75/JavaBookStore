package com.example.testtest.service.shop;

import com.example.testtest.exceptions.BookNotFoundException;
import com.example.testtest.exceptions.NotEnoughStockException;
import com.example.testtest.models.Book;
import com.example.testtest.models.BookDetails;
import com.example.testtest.repository.BookDetailsRepository;
import com.example.testtest.repository.BookRepository;
import com.example.testtest.service.shop.ShopService;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    public final BookRepository bookRepository;
    public final BookDetailsRepository bookDetailsRepository;

    public ShopServiceImpl(BookRepository bookRepository, BookDetailsRepository bookDetailsRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailsRepository = bookDetailsRepository;
    }

    @Override
    public Book buyBook(Long bookId, int no) {
        // check if book exists
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

        // check if book is in stock and if no exemplars exists
        if(book.getDetails().getQuantity() == 0 ||
                book.getDetails().getQuantity() < Integer.valueOf(no)) {
            throw new NotEnoughStockException();
        }

        BookDetails bookDetails = book.getDetails();
        bookDetails.setQuantity(bookDetails.getQuantity() - 1);
        bookDetailsRepository.save(bookDetails);
        book.setDetails(bookDetails);

        return bookRepository.save(book);
    }
}
