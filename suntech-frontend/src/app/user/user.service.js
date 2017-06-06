(function(){
    'use strict';
    
    angular
        .module("find.user")
        .service("UserService", UserService);
    
    UserService.$inject = ['$resource', 'API'];

    function UserService($resource, API){
        //Exports
        this.findUsers = _findUsers;

        var userAPI = $resource(API.url+"/v1/api/user");
        function _findUsers(filter){
            return userAPI.query({filter:filter}).$promise;
        }
    }
})();