package Lesson_1;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component("TreatmentHistory")
public class TreatmentHistory implements MedicalDocument {
	Integer number;
	Random random = new Random();

	public TreatmentHistory(){
		number = random.nextInt();
	}

	@Override
	public void giveDocument() {
		System.out.println("Получена история болезней пациента");
		System.out.println(number);
	}
}
