INSERT INTO `usuario`(`id`, `username`, `password`, `enabled`) VALUES (1, 'lucas', '$2a$10$ShwnwGDNRvqaXdnI4GsGFOVjwpx6i.n79XOcdVGsN6fcYepYRtMr6', true)
INSERT INTO `usuario`(`id`, `username`, `password`, `enabled`) VALUES (2, 'lucas2', '5678', true)
INSERT INTO `usuario`(`id`, `username`, `password`, `enabled`) VALUES (3, 'lucas3', '91011', true)

INSERT INTO `role`(`id`, `role`) VALUES (1, 'user')
INSERT INTO `role`(`id`, `role`) VALUES (2, 'manager')
INSERT INTO `role`(`id`, `role`) VALUES (3, 'admin')

INSERT INTO `usuario_roles`(`usuario_id`, `roles_id`) VALUES (1, 1)
INSERT INTO `usuario_roles`(`usuario_id`, `roles_id`) VALUES (1, 2)
INSERT INTO `usuario_roles`(`usuario_id`, `roles_id`) VALUES (2, 1)
INSERT INTO `usuario_roles`(`usuario_id`, `roles_id`) VALUES (3, 1)