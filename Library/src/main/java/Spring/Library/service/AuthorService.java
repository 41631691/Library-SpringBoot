package Spring.Library.service;

import Spring.Library.entity.Author;
import Spring.Library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;

    @Transactional
    public void create(Author dto){
        if (authorRepository.existsByNameAndSurname(dto.getName(), dto.getSurname()))
            throw new IllegalArgumentException("Error!");

        Author author = new Author();

        author.setName(dto.getName());
        author.setSurname(dto.getSurname());

        authorRepository.save(author);
    }

    @Transactional
    public void update(Author dto){
        Author author = authorRepository.findById(dto.getId()).get();

        author.setName(dto.getName());
        author.setSurname(dto.getSurname());

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public Author getById(Integer id){ return authorRepository.findById(id).get();}

    @Transactional(readOnly = true)
    public List<Author> getAll(){return authorRepository.findAll();}

    @Transactional
    public void enableById(Integer id){authorRepository.enableById(id);}

    @Transactional
    public void delete(Integer id){authorRepository.deleteById(id);}
}
