package webservice;

import org.apache.axis2.AxisFault;
import org.apache.axis2.ServiceObjectSupplier;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.Parameter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorldWebService implements ServiceObjectSupplier, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public Object getServiceObject(AxisService axisService) throws AxisFault {
        Parameter springBeanName = axisService.getParameter("SpringBeanName");
        String beanName = ((String) springBeanName.getValue()).trim();
        if (ctx == null)
            throw new AxisFault("applicationContext is NULL! ");
        if (ctx.getBean(beanName) == null)
            throw new AxisFault("Axis2 Can't find Spring Bean: " + beanName);
        return ctx.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = ctx;
    }
}
