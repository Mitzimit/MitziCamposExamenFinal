Ext.application({
    name:'formita',
    launch:function(){
     var forma=   Ext.create('Ext.form.Panel',{
            fullscreen:true,
            id:'formita',
    

           
            items:[
                {
                    xtype:'textfield',
                    id:'nombre',
                    name:'nombre',
                    placeHolder:'ingresa  nombre'
                }, {
                    xtype:'textfield',
                    id:'precio',
                    name:'precio',
                    placeHolder:'ingresa precio'
                }, {
                    xtype:'textfield',
                    id:'unidades',
                    name:'uidades',
                    placeHolder:'ingresa unidades'
                },
                {
                    xtype:'button',
                    ui:'confirm',
                    text:'oprimir',
                    handler:function(){
                    var a=ext.getCmp('nombre').setValue();
                    var b=ext.getCmp('precio').setValue();
                    var a=ext.getCmp('unidades').setValue();
                  Ext.Ajax.request({
                       method:'get',
            url:'/MitziCamposExamen/servicios/producto/'+a+'/'+b+'/'+c,
            params:{
                
            },
  
    success: function(response){
        var texto = response.responseText;
       Ext.getCmp('nombre').setValue(texto);
    },
    failure:function(response){
        Ext.Msg.alert("No hay conexion");
    }
});
                        
                    }
                },
                {
                    html:'<center><h2>Hola mundo</h2></center>'
                }
            ]
            
        });
    }
});
