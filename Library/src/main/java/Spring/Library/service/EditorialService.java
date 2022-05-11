package Spring.Library.service;

import Spring.Library.entity.Editorial;
import Spring.Library.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialService {

    private EditorialRepository editorialRepository;

    @Transactional
    public void create(Editorial dto){
        if (editorialRepository.existsByName(dto.getName()))
            throw new IllegalArgumentException("Error!");

        Editorial edi= new Editorial();
        edi.setName(dto.getName());
        editorialRepository.save(edi);
    }

    @Transactional
    public void update(Editorial dto){
        Editorial edi = editorialRepository.findById(dto.getId()).get();
        edi.setName(dto.getName());
        editorialRepository.save(edi);
    }

    @Transactional(readOnly = true)
    public Editorial getById(Integer id){return editorialRepository.findById(id).get();}

    @Transactional(readOnly = true)
    public List<Editorial> getAll(){return editorialRepository.findAll();}

    @Transactional
    public void enableById(Integer id){editorialRepository.enableById(id);}

    @Transactional
    public void delete(Integer id){editorialRepository.deleteById(id);}
}
