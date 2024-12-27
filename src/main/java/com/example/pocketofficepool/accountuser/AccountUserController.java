package com.example.pocketofficepool.accountuser;

import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import com.example.pocketofficepool.accountuser.converter.UserDtoToUserConverter;
import com.example.pocketofficepool.accountuser.converter.UserToUserDtoConverter;
import com.example.pocketofficepool.accountuser.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class AccountUserController {

    private final AccountUserService userService;

    private final UserDtoToUserConverter userDtoToUserConverter;

    private final UserToUserDtoConverter userToUserDtoConverter;

    public AccountUserController(AccountUserService userService, UserDtoToUserConverter userDtoToUserConverter, UserToUserDtoConverter userToUserDtoConverter) {
        this.userService = userService;
        this.userDtoToUserConverter = userDtoToUserConverter;
        this.userToUserDtoConverter = userToUserDtoConverter;
    }

    @GetMapping("/{userId}")
    public Result getUser(@PathVariable UUID userId) {
        AccountUser accountUser = this.userService.findUserById(userId);
        UserDto returnedUser = userToUserDtoConverter.convert(accountUser);
        return new Result(true, StatusCode.SUCCESS, "Successfully retrieved user", returnedUser);
    }

    @PostMapping()
    public Result createUser(@RequestBody UserDto userDto) {
        AccountUser accountUser = userDtoToUserConverter.convert(userDto);
        AccountUser savedAccountUser = this.userService.save(accountUser);
        UserDto savedUserDto = userToUserDtoConverter.convert(savedAccountUser);
        return new Result(true, StatusCode.SUCCESS, "Successfully created user", savedUserDto);
    }

    @PutMapping("/{userId}")
    public Result updateUser(@PathVariable UUID userId, @RequestBody UserDto userDto) {
        AccountUser accountUser = userDtoToUserConverter.convert(userDto);
        assert accountUser != null;
        AccountUser updatedAccountUser = this.userService.update(userId, accountUser);
        UserDto updatedUserDto = userToUserDtoConverter.convert(updatedAccountUser);
        return new Result(true, StatusCode.SUCCESS, "Successfully updated user", updatedUserDto);
    }

    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable UUID userId) {
        this.userService.delete(userId);
        return new Result(true, StatusCode.SUCCESS, "Successfully deleted user");
    }
}
