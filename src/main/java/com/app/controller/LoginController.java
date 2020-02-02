package com.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.Employee;
import com.app.mappers.EmployeeMapper;
import com.app.mappers.SelectExampleMapper;
import com.app.service.CamelInvokerService;
import com.app.service.SampleService;

@Controller
public class LoginController {

	@Autowired
	SampleService sampleService;

	@Autowired
	CamelContext camelContext;

	@Autowired
	CamelInvokerService invokerService;

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SelectExampleMapper selectExampleMapper;

	@RequestMapping(method = RequestMethod.GET, value = "/selectEx1")
	public ModelAndView myBatisSelectTest() throws Exception {
		System.out.println("myBatisSelectTest() -start");
		ModelAndView modelAndView = new ModelAndView();

		// invokerService.testChoice();

		// List<Employee> employeeList = employeeMapper.getAllEmployee();

		/*
		 * List<DepartmentResultDTO> deptList = employeeMapper.
		 * fetchDepartmentsWithEmployeesId();
		 * 
		 * 
		 * if(CollectionUtils.isEmpty(deptList)) {
		 * 
		 * System.out.println("deptList is null"); }else {
		 * deptList.stream().forEach(item->{ System.out.println(item); }); }
		 */

		// 1/25/2020

		/// EmployeesData employeesData = employeeMapper.fetchEmployeesDetails();

		// List<Employee> employeesList= employeeMapper.fetchEmployeesDetailsList();

		/*List<CourseData> fetchCourseDetails = employeeMapper.fetchCourseDetails();

		System.out.println(Objects.toString(fetchCourseDetails));*/
		
		
		/*List<CourseData> selectCourseWithDiscriminatorExample=	employeeMapper.selectCourseWithDiscriminatorExample();
		System.out.println(Objects.toString(selectCourseWithDiscriminatorExample));*/
		
		//TODO - SAVE Example 
		
		/*CourseDto courseDto = new CourseDto();
		courseDto.setId(Long.valueOf(1234));
		courseDto.setDuration(100);
		courseDto.setName("Test Course");
		
		CourseDto courseDtoRes = 	employeeMapper.saveCourseDetails(courseDto);
		
		System.out.println("courseDtoRes -> "+courseDtoRes);*/
		
		
		
		//1. Select Clause example 
		
		/*HashMap<String, Object>  selectExampleWithMap  =  selectExampleMapper.selectExampleWithMap(Long.valueOf(2));
		System.out.println("selectExampleWithMap  -> "+selectExampleWithMap);*/
		
		
		//2. Seelct with List as Map
		
		/*List<HashMap<String, Object>> 	selectExampleWithMapMultipleRow =	selectExampleMapper.	selectExampleWithMapMultipleRow ();
		System.out.println("selectExampleWithMapMultipleRow -> "+selectExampleWithMapMultipleRow);*/
		
		
		// 3. Select with Auto column example
	/*	List<Employee> selectWithAutoColumnMapping =   selectExampleMapper. selectWithAutoColumnMapping ();
		
		System.out.println("selectWithAutoColumnMapping -> "+selectWithAutoColumnMapping);*/
		
		/*List<	HashMap<String, Object> > selectWithSqlTagExample =   selectExampleMapper. selectWithSqlTagExample ();
		System.out.println("selectWithAutoColumnMapping -> "+selectWithSqlTagExample);*/
		
		
		
		
		// Save Employee  using for loop in my batis
		
		Employee employee = new Employee ();
		employee.setAdharNo(String.valueOf(new Random(10).nextLong()));
		employee.setCreatedDate(new Date());
		employee.setName("Admin Flee - 1");
		
		Employee employee2 = new Employee ();
		employee2.setAdharNo(String.valueOf(new Random(10).nextLong()));
		employee2.setCreatedDate(new Date());
		employee2.setName("Admin Flee -2 ");
		
		
		//selectExampleMapper.saveEmployeeExample1(employee);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(employee);
		employeeList.add(employee2);
		
		
		/*employeeList.stream().forEach(item->{
			Long id  = 	selectExampleMapper.selectEmployeeIdFieldValue();
			item.setId(id);
		});
		
		System.out.println("employeeList -> "+employeeList);
		
		selectExampleMapper.insertMultipleRowExample(employeeList);*/
		
		
		
		// Complex resultMap Example
		
		
		
		
		//List<DepartmentResultDTO> selectDepartmentWithEmployeesEx1  = selectExampleMapper.   selectDepartmentWithEmployeesEx1() ;
		
		//System.out.println("selectDepartmentWithEmployeesEx1 -> "+selectDepartmentWithEmployeesEx1);
		
		
		
		//Discriminator example  - Not working
		
		/*DiscriminatorExampleDTO discriminatorExampleDTO = selectExampleMapper.selectEmployeeWithDiscriminatorExample();
		System.out.println("discriminatorExampleDTO -> "+discriminatorExampleDTO);*/
		
		
		
		
		// Insert Example with return ID as well
		
		Employee employeeToSave = new Employee();
		
		employeeToSave.setAdharNo(String.valueOf(new Random(10).nextLong()));
		employeeToSave.setName("Dolly");
		employeeToSave.setEmail("Test@test.com");
		selectExampleMapper.saveEmployeeExample1(employeeToSave);
		
		System.out.println("employeeToSave -> "+employeeToSave);
		

		modelAndView.setViewName("SampleEx");
		System.out.println("myBatisSelectTest() -end");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/camelEx1")
	public ModelAndView camelEx() throws Exception {
		System.out.println("camelEx() -start");
		ModelAndView modelAndView = new ModelAndView();

		invokerService.invokeRestCallEx1();

		modelAndView.setViewName("SampleEx");
		System.out.println("camelEx() -end");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/Example04")
	public ModelAndView index() throws Exception {
		System.out.println("index() -start");
		ModelAndView modelAndView = new ModelAndView();
		ProducerTemplate template = null;
		try {
			ProducerTemplate producer = camelContext.createProducerTemplate();
			camelContext.start();

			producer.send("direct:sampleConfig", new Processor() {

				@Override
				public void process(Exchange exchange) throws Exception {
					Message message = exchange.getIn();

					System.out.println("process ()   - start");
					String body = "This is sample message !!!";
					message.setBody(body);

					System.out.println("process ()   - start");

				}
			});

		} finally {
			camelContext.stop();
		}

		/*
		 * List<BillDetails> bills = userDetailsMapper.findTotalBillDetails();
		 * 
		 * System.out.println(bills);
		 * 
		 * System.out.println( "---------------------------------------------------");
		 * 
		 * BillDetails bill = new BillDetails(151l, "Sample Code Test", "Test Note",
		 * 2344.00);
		 * 
		 * userDetailsMapper.saveBillDetails(bill);
		 * 
		 * List<BillDetails> billsAfter = userDetailsMapper.findTotalBillDetails();
		 * 
		 * System.out.println(billsAfter);
		 */
		modelAndView.setViewName("landing");
		System.out.println("index() -end");
		return modelAndView;

	}

	@RequestMapping(value = "/poll-file", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object pollFile() {
		System.out.println("pollFile() - start");

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		Exchange exchange = new DefaultExchange(camelContext);

		producerTemplate.send("direct:fetchFile", exchange);

		return new ResponseEntity<String>("Request is processed", HttpStatus.OK);

	}

	@RequestMapping(value = "aggregation-ex1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object aggregationStrategyExample() {
		System.out.println("aggregationStrategyExample() - start");

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		Exchange exchange = new DefaultExchange(camelContext);

		producerTemplate.send("direct:loadMemberData", exchange);

		return new ResponseEntity<String>("Request is processed", HttpStatus.OK);

	}

//direct:startApiClient	

	@RequestMapping(value = "startApiClient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object startApiClient() {
		System.out.println("startApiClient	() - start");

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		Exchange exchange = new DefaultExchange(camelContext);

		// producerTemplate.send("direct:startApiClient", exchange);

		// direct:directExampleOfException1
		producerTemplate.send("direct:directExampleOfException1", exchange);
		return new ResponseEntity<String>("Request is processed", HttpStatus.OK);

	}

	// direct:exampleRouteOne-1

	@RequestMapping(value = "exceptionExample", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object exceptionExample() {
		System.out.println("exceptionExample	() - start");

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		Exchange exchange = new DefaultExchange(camelContext);

		// producerTemplate.send("direct:startApiClient", exchange);

		// direct:directExampleOfException1
		producerTemplate.send("direct:exampleRouteOne-1", exchange);
		return new ResponseEntity<String>("Request is processed", HttpStatus.OK);

	}
}
