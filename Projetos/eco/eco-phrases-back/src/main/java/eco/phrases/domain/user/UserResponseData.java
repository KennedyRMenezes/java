package eco.phrases.domain.user;

public record UserResponseData(Long id,
                                String name,
                               String email) {

    public UserResponseData(User u){
        this(u.getId(),u.getName(), u.getEmail());
    }
}
