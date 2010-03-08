package madvirus.spring.chap11;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

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

	public void save(Config config, Result result) throws XmlMappingException,
			IOException {
		marshaller.marshal(config, result);
	}

	public Config load(Source source) throws XmlMappingException, IOException {
		return (Config) unmarshaller.unmarshal(source);
	}
}
