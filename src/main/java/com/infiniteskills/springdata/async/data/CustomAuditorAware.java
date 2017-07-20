package com.infiniteskills.springdata.async.data;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String>
{

    @Override
    public String getCurrentAuditor()
    {
        return "J Bellars";
    }
}
