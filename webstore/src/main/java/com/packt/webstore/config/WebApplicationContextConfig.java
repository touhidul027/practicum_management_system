package com.packt.webstore.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.AdminRepository;
import com.packt.webstore.domain.repository.NoticeRepository;
import com.packt.webstore.domain.repository.ProjectProposalRepository;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.domain.repository.SupervisorRepository;
import com.packt.webstore.domain.repository.UserRepository;
import com.packt.webstore.domain.repository.graph.CanvasjsChartDao;
import com.packt.webstore.domain.repository.graph.impl.CanvasjsChartDaoImpl;
import com.packt.webstore.domain.repository.graph.impl.ChartRepositoryImpl;
import com.packt.webstore.domain.repository.impl.AdminRepositoryImpl;
import com.packt.webstore.domain.repository.impl.NoticeRepositoryImpl;
import com.packt.webstore.domain.repository.impl.ProjectProposalRepositoryImpl;
import com.packt.webstore.domain.repository.impl.StudentRepositoryImpl;
import com.packt.webstore.domain.repository.impl.SupervisorRepositoryImpl;
import com.packt.webstore.domain.repository.impl.UserRepositoryImpl;
import com.packt.webstore.interceptor.ProcessingTimeLogInterceptor;
import com.packt.webstore.interceptor.PromoCodeInterceptor;
import com.packt.webstore.service.AdminService;
import com.packt.webstore.service.EmailService;
import com.packt.webstore.service.NoticeService;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;
import com.packt.webstore.service.UserService;
import com.packt.webstore.service.graph.CanvasjsChartService;
import com.packt.webstore.service.graph.ChartService;
import com.packt.webstore.service.graph.impl.CanvasjsChartServiceImpl;
import com.packt.webstore.service.graph.impl.ChartServiceImpl;
import com.packt.webstore.service.impl.AdminServiceImpl;
import com.packt.webstore.service.impl.EmailServiceImpl;
import com.packt.webstore.service.impl.NoticeServiceImpl;
import com.packt.webstore.service.impl.ProjectProposalServiceImpl;
import com.packt.webstore.service.impl.StudentServiceImpl;
import com.packt.webstore.service.impl.SupervisorServiceImpl;
import com.packt.webstore.service.impl.UserServiceImpl;
import com.packt.webstore.validator.ProductValidator;
import com.packt.webstore.validator.UnitsInStockValidator;
import com.packt.webstore.domain.repository.graph.ChartRepository;
import com.packt.webstore.service.ProjectProposalService;

@Configuration
@EnableWebMvc
@ComponentScan("com.packt.webstore")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);

		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		return resource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint(true);

		return jsonView;
	}

	@Bean
	public MarshallingView xmlView() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Product.class);

		MarshallingView xmlView = new MarshallingView(marshaller);
		return xmlView;
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		ArrayList<View> views = new ArrayList<>();
		views.add(jsonView());
		views.add(xmlView());

		resolver.setDefaultViews(views);

		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ProcessingTimeLogInterceptor());

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor);

		registry.addInterceptor(promoCodeInterceptor()).addPathPatterns("/**/market/products/specialOffer");
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));

		return resolver;
	}

	@Bean
	public HandlerInterceptor promoCodeInterceptor() {
		PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
		promoCodeInterceptor.setPromoCode("OFF3R");
		promoCodeInterceptor.setOfferRedirect("market/products");
		promoCodeInterceptor.setErrorRedirect("invalidPromoCode");

		return promoCodeInterceptor;
	}

	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Bean
	public ProductValidator productValidator() {
		Set<Validator> springValidators = new HashSet<>();
		springValidators.add(new UnitsInStockValidator());

		ProductValidator productValidator = new ProductValidator();
		productValidator.setSpringValidators(springValidators);

		return productValidator;
	}

	@Bean
	public StudentService studentService() {
		return new StudentServiceImpl();
	}

	@Bean
	public StudentRepository studentRepository() {
		return new StudentRepositoryImpl();
	}

	@Bean
	public SupervisorService supervisorService() {
		return new SupervisorServiceImpl();
	}

	@Bean
	public SupervisorRepository supervisorRepository() {
		return new SupervisorRepositoryImpl();
	}

	@Bean
	public AdminService adminService() {
		return new AdminServiceImpl();
	}

	@Bean
	public AdminRepository adminRepository() {
		return new AdminRepositoryImpl();
	}

	@Bean
	public NoticeService noticeService() {
		return new NoticeServiceImpl();
	}

	@Bean
	NoticeRepository noticeRepository() {
		return new NoticeRepositoryImpl();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("my.gmail@gmail.com");
		mailSender.setPassword("password");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}

	@Bean
	public CanvasjsChartService CanvasjsChartService() {
		return new CanvasjsChartServiceImpl();
	}
	
	@Bean
	public CanvasjsChartDao canvasjsChartDao() {
		return new CanvasjsChartDaoImpl();
	}
	
	@Bean
	public ChartService chartService() {
		return new ChartServiceImpl();
	}
	
	@Bean
	public ChartRepository ChartRepository() {
		return new ChartRepositoryImpl();
	}
	
	@Bean
	public ProjectProposalService ProjectProposalService() {
		return new ProjectProposalServiceImpl();
	}
	
	 @Bean
	public ProjectProposalRepository projectProposalRepository() {
		return new ProjectProposalRepositoryImpl();
	}
}
