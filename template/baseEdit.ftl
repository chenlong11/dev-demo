<div style="text-align:center">
    <h1>${domainName} Edit</h1>
    <form id="form" action="${r'${ctx}'}${controllerMapping}/${r'${info.id}'}" method="post">
        <table style="margin:auto">
            [#list domainColumns as column]
            <tr>
                <td style="width: 15%;">
                    <label >String：</label>
                </td>
                <td>
                    <input type="text" name="demoString" value="${r'${info.demoString}'}"/>
                </td>
            </tr>
            [/#list]
        </table>
    </form>
</div>

<script>
    $(function () {
        $("#form").validate({
            rules: {
                demoString: {
                    required: true,
                    rangelength: [2, 20]
                },demoInt: {
                    digits:true,
                    max: 100
                },demoDouble: {
                    double:true
                },demoLong: {
                    digits:true,
                    max: 10000
                }
            },
            submitHandler: function() {
                $('#form').ajaxSubmit({
                    dataType: 'json',
                    success: function (data) {
                        if (data.status != 1) {
                            errMsg();
                        }
                        sucessMsg(function () {
                            closeAllDialog();
                            query();
                        });
                    }
                })
            }
        });
    })
</script>
