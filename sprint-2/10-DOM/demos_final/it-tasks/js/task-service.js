class TaskService {

    getListTitle() {
        return 'IT Support Tasks';
    }

    getTasks() {
        return [
            {
                    id: 1,
                    dueDate: '2024-08-30',
                    priority: 1,
                    title: 'Network outage at HQ'
            },
            {
                    id: 2,
                    dueDate: '2024-09-06',
                    priority: 3,
                    title: 'Check printers on Level 2'
            },
            {
                    id: 3,
                    dueDate: '2024-09-05',
                    priority: 3,
                    title: 'Install software on new hire laptops'
            },
            {
                    id: 4,
                    dueDate: '2024-09-06',
                    priority: 3,
                    title: 'Train new hires on IT procedures'
            },
            {
                    id: 5,
                    dueDate: '2024-08-30',
                    priority: 1,
                    title: 'Install database security patch'
            },
            {
                    id: 6,
                    dueDate: '2024-08-31',
                    priority: 2,
                    title: 'Weekly system backup'
            },
            {
                    id: 7,
                    dueDate: '2024-09-03',
                    priority: 3,
                    title: 'Create new user accounts for upcoming new hires'
            },
            {
                    id: 8,
                    dueDate: '2024-09-02',
                    priority: 2,
                    title: 'Upgrade antivirus on windows desktops'
            },
            {
                    id: 9,
                    dueDate: '2024-09-02',
                    priority: 2,
                    title: 'User support for recent software update'
            },
            {
                    id: 10,
                    dueDate: '2024-09-03',
                    priority: 3,
                    title: 'Decommission old server'
            }
        ]
    }
}