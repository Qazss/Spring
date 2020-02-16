package Lesson_1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component("MedicalRecord")
public class MedicalRecord implements MedicalDocument {

	@Override
	public void giveDocument() {
		System.out.println("Получена медицинская карточка пациента");
	}
}
