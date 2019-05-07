import com.mera.inkrot.apachecxf.service.HelloService;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class TestHelloService {

    @Test
    public void testWhatIsTheAnswer() {

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.setServiceClass(HelloService.class);
        factoryBean.setAddress("http://localhost:8080/api/hello");

        HelloService service = (HelloService) factoryBean.create();
        service.hello("some answer");

    }
}
