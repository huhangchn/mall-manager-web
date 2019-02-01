package ${basePackage}.web;
import ${basePackage}.result.Result;
import ${basePackage}.result.ResultFactory;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ResultFactory.success(${modelNameLowerCamel}Service.save(${modelNameLowerCamel}));
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        return ResultFactory.success(${modelNameLowerCamel}Service.deleteById(id));
    }

    @PostMapping("/update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ResultFactory.success(${modelNameLowerCamel}Service.update(${modelNameLowerCamel}));
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        return ResultFactory.success(${modelNameLowerCamel}Service.findById(id));
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(${modelNameLowerCamel}Service.findAll(page, size));
    }
}
