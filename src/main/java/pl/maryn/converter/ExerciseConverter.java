package pl.maryn.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.maryn.entity.training.Exercise;
import pl.maryn.repository.ExerciseRepository;

public class ExerciseConverter implements Converter<String, Exercise> {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise convert(String source) {
        Exercise group = exerciseRepository.findById(Long.parseLong(source));
        return group;
    }
}
