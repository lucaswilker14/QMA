qmaApp.factory('tokenInterceptor', function () {

    //as factorys tem que retornar sempre um objeto
    //esse object vai ser cadastrado no array de interceptor
        return {
            'request': function (config) {
                config.headers.Authorization = 'Bearer ' + localStorage.getItem('userToken');
                return config;
            }
        };
});
