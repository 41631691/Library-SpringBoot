package Spring.Library.service;

import Spring.Library.entity.Book;
import Spring.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    @Transactional
    public void create(Book dto) {
        Book book = new Book();

        book.setIsbn(dto.getIsbn());
        book.setTitulo(dto.getTitulo());
        book.setYear(dto.getYear());
        book.setAuthor(dto.getAuthor());
        book.setEjemplares(dto.getEjemplares());
        bookRepository.save(book);
    }

    @Transactional
    public void update(Book dto) {
        Book book = bookRepository.findById(dto.getId()).get();

        book.setIsbn(dto.getIsbn());
        book.setTitulo(dto.getTitulo());
        book.setYear(dto.getYear());
        book.setAuthor(dto.getAuthor());
        book.setEjemplares(dto.getEjemplares());
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book getByID(Integer id){return bookRepository.findById(id).get();}

    @Transactional(readOnly = true)
    public List<Book> getALl(){return bookRepository.findAll();}

    @Transactional
    public void enableById(Integer id){bookRepository.enableById(id);}

    @Transactional
    public void delete(Integer id){bookRepository.deleteById(id);}
}
