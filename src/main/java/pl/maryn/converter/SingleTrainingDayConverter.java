package pl.maryn.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.maryn.entity.training.SingleTrainingDay;
import pl.maryn.repository.SingleTrainingDayRepository;

public class SingleTrainingDayConverter implements Converter<String, SingleTrainingDay> {

    @Autowired
    private SingleTrainingDayRepository singleTrainingDayRepository;

    @Override
    public SingleTrainingDay convert(String source) {
        SingleTrainingDay group = singleTrainingDayRepository.findById(Long.parseLong(source));
        return group;
    }


}
