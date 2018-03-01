<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/3/1
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    asd
    <div class="row">
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
    </div>
    <div class="row">
        <div class="col-md-8">.col-md-8</div>
        <div class="col-md-4">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-6">.col-md-6</div>
        <div class="col-md-6">.col-md-6</div>
    </div>
    <div class="row">
        <div class="col-xs-9">.col-xs-9</div>
        <div class="col-xs-4">.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line
            as one contiguous unit.
        </div>
        <div class="col-xs-6">.col-xs-6<br>Subsequent columns continue along the new line.</div>
    </div>
    <h1>h1. Bootstrap heading
        <small>Secondary text</small>
    </h1>
    <h2>h2. Bootstrap heading
        <small>Secondary text</small>
    </h2>
    <h3>h3. Bootstrap heading
        <small>Secondary text</small>
    </h3>
    <h4>h4. Bootstrap heading
        <small>Secondary text</small>
    </h4>
    <h5>h5. Bootstrap heading
        <small>Secondary text</small>
    </h5>
    <h6>h6. Bootstrap heading
        <small>Secondary text</small>
    </h6>
    <table>
        <!-- On rows -->
        <tr class="active">tttttttttttttt</tr>
        <tr class="success">ttttttttttttttt...</tr>
        <tr class="warning">.tttttttt..</tr>
        <tr class="danger">.ttttttttt..</tr>
        <tr class="info">.tttttttttt..</tr>

        <!-- On cells (`td` or `th`) -->
        <tr>
            <td class="active">ABBBBB</td>
            <td class="success">ABBBBB</td>
            <td class="warning">ABBBBB</td>
            <td class="danger">ABBBBB</td>
            <td class="info">ABBBBB</td>
        </tr>
    </table>
</div>
<form class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control has-feedback" id="exampleInputEmail3" placeholder="Email">
    </div>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control has-feedback" id="exampleInputPassword3" placeholder="Password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button type="submit" class="btn btn-default">Sign in</button>
</form>
<div class="form-group has-success">
    <label class="control-label" for="inputSuccess1">Input with success</label>
    <input type="text" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2">
    <span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
</div>
<div class="form-group has-warning">
    <label class="control-label" for="inputWarning1">Input with warning</label>
    <input type="text" class="form-control" id="inputWarning1">
</div>
<div class="form-group has-error">
    <label class="control-label" for="inputError1">Input with error</label>
    <input type="text" class="form-control" id="inputError1">
</div>
<div class="has-success">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxSuccess" value="option1">
            Checkbox with success
        </label>
    </div>
</div>
<div class="has-warning">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxWarning" value="option1">
            Checkbox with warning
        </label>
    </div>
</div>
<div class="has-error">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxError" value="option1">
            Checkbox with error
        </label>
    </div>
</div>
</body>
</html>
