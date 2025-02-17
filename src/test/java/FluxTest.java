import com.reactive.Reactive.Project.services.FluxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FluxTest {
    @Autowired
    private FluxService fluxService;

    @Test
    public void simpleFluxTest() {
        fluxService.getFlux().subscribe(data -> {
            System.out.println(data);
            System.out.println("Done with Flux Data");
        });
    }
}
