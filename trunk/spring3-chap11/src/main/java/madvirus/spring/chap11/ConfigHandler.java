package madvirus.spring.chap11;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class ConfigHandler {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void save(Config config, File file) throws XmlMappingException,
			IOException {
		marshaller.marshal(config, new StreamResult(file));
	}

	public Config load(File file) throws XmlMappingException, IOException {
		return (Config) unmarshaller.unmarshal(new StreamSource(file));
	}
}
