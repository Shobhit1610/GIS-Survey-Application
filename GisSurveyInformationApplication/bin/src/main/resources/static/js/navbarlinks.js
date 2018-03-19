			function dashboard()
			{
				document.navform.action="admin";
        		submitMyForm();
			}
			function adduser()
        	{
				document.navform.action="admin/user/addUser";
        		submitMyForm();
        	}
        	function edituser()
        	{
        		document.navform.action="admin/user/editUser";
        		submitMyForm();
        	}
        	function deleteuser()
        	{
        		document.navform.action="admin/user/deleteUser";
        		submitMyForm();
        	}
        	function addtable()
        	{
        		document.navform.action="admin/table/addTable";
        		submitMyForm()
        	}
        	function deletetable()
        	{
        		document.navform.action="admin/table/deleteTable";
        		submitMyForm()
        	}
        	function showuser()
        	{
        		document.navform.action="admin/user/showUser";
        		submitMyForm();
        	}
        	function showtable()
        	{
        		document.navform.action="admin/table/showTable";
        		submitMyForm();
        	}
        	function submitMyForm()
        	{
        		document.navform.submit();
        	}