package com.lendico.repayment_plan;

import com.lendico.repayment_plan.pojos.InputParameters;
import com.lendico.repayment_plan.pojos.output;
import com.lendico.repayment_plan.service.CalculateAnnuity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class RepaymentPlanApplicationTests {


	CalculateAnnuity calculateAnnuity = new CalculateAnnuity();

	@Test
	public void Test() {

		InputParameters inputParameters = new InputParameters();

		inputParameters.setAmount(5000.00);
		inputParameters.setDuration(2);
		inputParameters.setPayout("2018-01-01");
		inputParameters.setRate(5);

		List<output> out = calculateAnnuity.process(inputParameters);

		assertThat(out.get(0).getBorrowerPaymentAmount(), is(equalTo(219.36)));

		LocalDate lDate = out.get(0).getDate();
		String strDate = lDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		assertThat(strDate, is(equalTo("01/01/2018")));
		assertThat(out.get(0).getInitialOutstandingPrincipal(), is(equalTo(5000.0)));
		assertThat(out.get(0).getInterest(), is(equalTo(20.83)));
		assertThat(out.get(0).getPrincipal(), is(equalTo(198.53)));
		assertThat(out.get(0).getRemainingOutstandingPrincipal(), is(equalTo(4801.47)));

	}

}
