package pl.maryn.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.maryn.entity.training.Training;
import pl.maryn.repository.TrainingRepository;

public class TrainingConverter implements Converter<String, Training> {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public Training convert(String source) {
        Training group = trainingRepository.findById(Long.parseLong(source));
        return group;
    }
}
