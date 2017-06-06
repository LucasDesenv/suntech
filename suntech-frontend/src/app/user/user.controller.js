(function(){
    'use strict';

    angular
        .module("find.user")
        .controller("UserController", UserController);

    UserController.$inject = ['UserService'];

    function UserController(userService){
        
        // Exports
        var vm = this;
        vm.pageTitle = "Users Search";
        vm.findUsers = _findUsers;
        vm.clean = _clean;

        function _findUsers(){
            userService.findUsers(vm.filter)
            .then(function(response){
                vm.users = response;
            })
            .catch(function(error){
                console.log(error);
                vm.users = undefined;
            });
        }

        function _clean(){
            vm.filter = '';
            vm.users = undefined;
        }
    }
})();