<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Calculator project</title>
    </head>

    <body>
        <form action="calculation" method="get" enctype="multipart/form-data">  
		<table>
			<tr>
				<td>Please Enter An Integer x: </td>
				<td><input type="text" name="bigint1" value="" /></td>
			</tr>
			
			<tr>
				
				<td>Please Enter An Integer y: </td>
				<td><input type="text" name="bigint2" value="" /></td>
				
			</tr>
                        <tr> 
                            <td>
                                <select name = "operator">
                                    <option value="Default">Please Select an Operator: </option>
                                    <option value="Addition">Addition</option>
                                    <option value="Multiplication">Multiplication</option>
                                    <option value="Prime">Relatively Prime</option>
                                    <option value="Modulo">x mod y</option>
                                    <option value="Inversemodular">Inverse modular(x-1 mod y)</option>
                                    <option value="Power">Raise x to the power of y</option>
                                 </select>
                            </td>
                             <td>
                                <input type="submit" name="submit" value="Submit" />
                            </td>
                        </tr>
                        
                </table>
        </form>
    </body>
</html>
