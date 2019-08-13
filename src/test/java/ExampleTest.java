import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
@AutoConfigureMockMvc
public class ExampleTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void exampleTest() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World!\n"));
		// @formatter:on
	}

}