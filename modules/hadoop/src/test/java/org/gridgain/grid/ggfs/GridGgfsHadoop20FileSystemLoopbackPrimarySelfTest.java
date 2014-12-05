/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.ggfs;

import static org.apache.ignite.fs.IgniteFsMode.*;
import static org.gridgain.grid.util.ipc.shmem.GridIpcSharedMemoryServerEndpoint.*;

/**
 * Tests Hadoop 2.x file system in primary mode.
 */
public class GridGgfsHadoop20FileSystemLoopbackPrimarySelfTest extends GridGgfsHadoop20FileSystemAbstractSelfTest {
    /**
     * Creates test in primary mode.
     */
    public GridGgfsHadoop20FileSystemLoopbackPrimarySelfTest() {
        super(PRIMARY);
    }

    /** {@inheritDoc} */
    @Override protected String primaryFileSystemUriPath() {
        return "ggfs://ggfs:" + getTestGridName(0) + "@/";
    }

    /** {@inheritDoc} */
    @Override protected String primaryFileSystemConfigPath() {
        return "/modules/core/src/test/config/hadoop/core-site-loopback.xml";
    }

    /** {@inheritDoc} */
    @Override protected String primaryIpcEndpointConfiguration(String gridName) {
        return "{type:'tcp', port:" + (DFLT_IPC_PORT + getTestGridIndex(gridName)) + "}";
    }

    /** {@inheritDoc} */
    @Override protected String secondaryFileSystemUriPath() {
        assert false;

        return null;
    }

    /** {@inheritDoc} */
    @Override protected String secondaryFileSystemConfigPath() {
        assert false;

        return null;
    }

    /** {@inheritDoc} */
    @Override protected String secondaryIpcEndpointConfiguration() {
        assert false;

        return null;
    }
}
