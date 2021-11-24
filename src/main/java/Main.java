import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuizeService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizeService service = context.getBean(QuizeService.class);
        System.out.println(service.showQuestions());
    }
}
