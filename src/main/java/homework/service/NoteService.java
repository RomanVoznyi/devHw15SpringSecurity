package homework.service;

import homework.model.Note;
import homework.model.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public boolean isExist(long id) {
       return noteRepository.existsById(id);
    }

    public void deleteById(long id) {
        if(!isExist(id)){
            throw new IllegalArgumentException("Note with id '" + id + "' does not exist");
        }
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
       noteRepository.save(note);
    }

    public Note getById(long id) {
        if(!isExist(id)){
            throw new IllegalArgumentException("Note with id '" + id + "' does not exist");
        }
        return noteRepository.getReferenceById(id);
    }
}
