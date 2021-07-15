package keyboard.works;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import keyboard.works.entity.User;
import keyboard.works.repository.UserRepository;

@Component
public class AuditorProvider implements AuditorAware<String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<String> getCurrentAuditor() {
		
		Optional<User> user = userRepository.findById("1");
		
		return Optional.ofNullable(user.get().getName());
	}

}
