package Lesson_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Registry")
public class Registry implements Hospital {
	private MedicalDocument medicalDocument;

	@Value("503a")
	private String cabinet;

	@Autowired
	@Qualifier("MedicalRecord")
	public void setMedicalDocument(MedicalDocument medicalDocument) {
		this.medicalDocument = medicalDocument;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	@Override
	public void giveInfo() {
		System.out.println("Кабинет: " + cabinet);
		medicalDocument.giveDocument();
	}
}
