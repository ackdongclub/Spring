package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component가 붙은 class를 모두 자동으로 bean으로 등록한다
        //basePackages = "hello.core.member", //해당 페키지의 하위 클래스들만 bean이 등록된다
        //basePackageClasses = AutoAppConfig.class, //class로 설정해서 해당 패키지를 찾을 수 있다
        //위를 지정하지 않는다면 package hello.core;의 하위 패키지를 모두 다 뒤진다
        //패키지 위치를 지정하지 않고 설정 정보 클래스의 위치를 프로젝트 최상단에 둔다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //AppConfig는 자동으로 등록되면 안되기 때문에 뺐다 -> 충돌 방지
)

public class AutoAppConfig {

}
