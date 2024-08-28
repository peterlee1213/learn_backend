package com.example.security_11_architecture;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;

import jakarta.annotation.Resource;
import jakarta.servlet.Filter;

@SpringBootTest
class Security11ArchitectureApplicationTests {

	@Resource
	private FilterChainProxy filterChainProxy;
	
	@Test
	void printSecurityFiltersInDefaultSecurityFilterChain() {
		filterChainProxy.getFilterChains().forEach(chain -> {
            List<Filter> filters = chain.getFilters();
			// 在这下面一行打断点可看到filters中的内容
            filters.forEach(filter -> {
                System.out.println("Filter: " + filter);
            });
        });
	}

}
